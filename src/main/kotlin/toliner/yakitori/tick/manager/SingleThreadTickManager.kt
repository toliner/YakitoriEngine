/*
 * Copyright (c) 2018. toliner. All rights reserved.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package toliner.yakitori.tick.manager

import toliner.yakitori.tick.*

/**
 * 最も単純な[ITickManager]の実装です。
 * 全ての処理は直列的に行われます。
 * tick処理間の間隔は、システム時間の差分を用いて管理されます。
 * runメソッドは実行されたスレッドで処理を開始します。
 *
 * @param tickRate 1秒あたりの最大tick数です。tpsの上限はこの値になります。
 * @param workers 管理対象の[ITickWorker]の参照を保持する可変リストです。初期値は[ArrayList]です。空のリストが推奨されます。
 */
class SingleThreadTickManager(private val tickRate: Int, override val workers: MutableList<ITickWorker> = ArrayList()) : AbstractTickManager() {

    init {
        if (tickRate <= 0) {
            throw IllegalArgumentException("tickRate must be positive")
        }
    }

    /**
     * 1tickあたりの最大の処理時間(ms)です。
     */
    private val tickTime = 1000 / tickRate
    /**
     * 前回のtps更新が行われた時間をUNIX時間で表します。
     */
    private var oldTime = System.currentTimeMillis()
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
     * 愚直に直列処理を行います。
     * このメソッドを呼び出したスレッドで処理を開始するため、
     * 途中で中断や終了をすることはできません。
     */
    override fun run() {
        while (true) {
            tickCount++
            for (worker in workers) {
                worker.onTick()
            }
            val delay = tickTime - System.currentTimeMillis() + oldTime
            if (delay > 0) {
                Thread.sleep(delay)
            }
        }
    }
}