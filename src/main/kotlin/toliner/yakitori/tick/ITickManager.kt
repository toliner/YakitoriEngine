/*
 * Copyright (c) 2018. toliner. All rights reserved.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package toliner.yakitori.tick

import toliner.yakitori.tick.manager.*

/**
 * [ITickWorker]を管理し、tick処理を司るクラスのインターフェースです。
 * 全ての標準実装は[toliner.yakitori.tick.manager]パッケージに存在します。
 *
 * @see ITickWorker
 * @see IPausableTickManager
 * @see AbstractTickManager
 * @see SingleThreadTickManager
 * @see TimerTickManager
 * @see SingleThreadTimerTickManager
 * @see ParallelTickManager
 */
interface ITickManager {
    /**
     * tpsとは、tick per second、つまり1秒あたりのtick数のことです。
     * 実測のtpsを取得します。
     * 精度・更新頻度は実装に依存します。
     */
    val tps: Float

    /**
     * 管理対象となる[ITickWorker]を追加します。
     *
     * @param worker 管理対象に追加する[ITickWorker]
     */
    fun addWorker(worker: ITickWorker)

    /**
     * 管理対象から特定の[ITickWorker]を削除します。
     *
     * @param worker 管理対象から削除する[ITickWorker]
     * @return 削除に成功したか否か
     */
    fun removeWorker(worker: ITickWorker): Boolean

    /**
     * 特定の[ITickWorker]が管理対象に含まれているかを確認します。
     *
     * @param worker 確認を行う[ITickWorker]
     * @return [worker]が管理対象に含まれているか否か
     */
    fun workerContains(worker: ITickWorker): Boolean

    /**
     * 管理対象となる[ITickWorker]を追加する、+=演算子のオーバーロードです。
     * 標準実装において、これは[addWorker]のラッパーです。
     *
     * @param worker 管理対象に追加する[ITickWorker]
     */
    operator fun plusAssign(worker: ITickWorker)

    /**
     * 管理対象から特定の[ITickWorker]を削除します。
     * 標準実装において、これは[removeWorker]のラッパーです。
     *
     * @param worker 管理対象から削除する[ITickWorker]
     */
    operator fun minusAssign(worker: ITickWorker)

    /**
     * tick処理を開始します。
     * この処理によってスレッドがブロックされるか否か(処理がこのスレッドで行われるか別のスレッドで行われるか)は実装に依存します。
     * 中断可能か否かは実装に依存します。
     */
    fun run()
}