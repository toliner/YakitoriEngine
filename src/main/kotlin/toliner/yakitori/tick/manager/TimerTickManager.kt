/*
 * Copyright (c) 2018. toliner. All rights reserved.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package toliner.yakitori.tick.manager

import toliner.yakitori.tick.*
import java.util.*

/**
 * [Timer]を用いて、より厳密にtickの処理時間を管理する[ITickManager]の実装のための抽象クラスです。
 * 全てのtick処理はTimerによって別スレッドで実行されます。
 * そのため、停止・再開が可能です。
 * [tps]は、tickRateで指定した回数、tick処理が行われるごとに更新されます。
 *
 * @param tickRate 1秒あたりの最大tick数です。tpsの上限はこの値になります。
 * @param workerList [workers]に用いる初期リストです。空のリストを用いることが推奨されます。デフォルトでは[LinkedList]が用いられます。
 */
abstract class TimerTickManager(tickRate: Long, workerList: MutableList<ITickWorker> = LinkedList()) : AbstractTickManager(), IPausableTickManager {

    init {
        if (tickRate <= 0) {
            throw IllegalArgumentException("tickRate must be positive")
        }
    }

    /**
     * Timerによって別のスレッドからアクセスされるため、コンストラクタで与えられた初期リストを用いた
     * スレッドセーフなリストを生成します。
     */
    override val workers: MutableList<ITickWorker> = Collections.synchronizedList(workerList)!!
    /**
     * tick処理の計画実行に用いられる[Timer]です。
     */
    private val timer = Timer()
    /**
     * 1tickあたりの最大の処理時間(ms)です。
     */
    private val tickTime = 1000 / tickRate
    /**
     * tick処理に用いられる[TimerTask]です。
     * [workers]のtick処理、tpsの更新、次のtick処理のスケジュールを行います。
     * tick処理は[handle]に委譲されます。
     */
    private val task = object : TimerTask() {
        /**
         * 前回のtps更新が行われた時間をUNIX時間で表します。
         */
        private var oldTime = 0L
        /**
         * 前回のtps更新からの現在のtick数です。
         * tickRateで指定された回数tick処理が行われるごとにtpsを更新し、値を0にリセットします。
         */
        private var tickCount = 0L
            set(value) {
                val count = value % tickRate
                if (count == 0L) {
                    val now = System.currentTimeMillis()
                    tps = count / (now - oldTime).toFloat()
                    oldTime = now
                }
                field = count
            }

        /**
         * 実際の処理を行います。
         * tick処理は[handle]に委譲されます。
         */
        override fun run() {
            tickCount++
            handle()
            timer.schedule(this, tickTime - System.currentTimeMillis() + oldTime)
        }
    }

    override fun run() {
        timer.schedule(task, 0)
    }

    override fun start() {
        run()
    }

    override fun pause() {
        timer.cancel()
    }

    /**
     * [task]から委譲されたtick処理です。
     */
    protected abstract fun handle()
}