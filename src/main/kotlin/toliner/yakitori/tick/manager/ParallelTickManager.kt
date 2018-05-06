/*
 * Copyright (c) 2018. toliner. All rights reserved.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package toliner.yakitori.tick.manager

import kotlinx.coroutines.experimental.launch
import toliner.yakitori.tick.ITickWorker
import java.util.*

/**
 * コルーチンを用いてtick処理を非同期的に処理する[TimerTickManager]の実装です。
 * 全てのtick処理は非同期的に処理されます。
 * 同時実行数は実行環境に依存します。
 * 実行順序は不定です。
 * このクラスを利用する場合、全ての管理対象となる[ITickWorker]は非同期的に実行されることを留意して作成する必要があります。
 *
 * @param tickRate 1秒あたりの最大tick数です。tpsの上限はこの値になります。
 * @param workerList 管理対象の[ITickWorker]の参照を保持する可変リストです。初期値は[LinkedList]です。空のリストが推奨されます。
 */
class ParallelTickManager(tickRate: Long, workerList: MutableList<ITickWorker> = LinkedList()) : TimerTickManager(tickRate, workerList) {
    override fun handle() {
        launch {
            workers.map {
                launch {
                    it.onTick()
                }
            }.forEach {
                it.join()
            }
        }
    }
}