/*
 * Copyright (c) 2018. toliner. All rights reserved.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package toliner.yakitori.tick.manager

import toliner.yakitori.tick.ITickWorker
import java.util.*

/**
 * 最も単純な[TimerTickManager]の実装です。
 * [SingleThreadTickManager]と同じ方法でtick処理を行います。
 * [SingleThreadTickManager]と比べて、
 * [Timer]によって生成されたスレッドで実行されるため、呼び出しスレッドをブロックしないという利点があります。
 *
 * @param tickRate 1秒あたりの最大tick数です。tpsの上限はこの値になります。
 * @param workerList 管理対象の[ITickWorker]の参照を保持する可変リストです。初期値は[LinkedList]です。空のリストが推奨されます。
 */
class SingleThreadTimerTickManager(tickRate: Long, workerList: MutableList<ITickWorker> = LinkedList()) : TimerTickManager(tickRate, workerList) {
    override fun handle() {
        for (worker in workers) {
            worker.onTick()
        }
    }
}