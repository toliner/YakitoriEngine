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