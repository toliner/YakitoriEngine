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

class SingleThreadTimerTickManager(tickRate: Long, workerList: MutableList<ITickWorker> = LinkedList()) : TimerTickManager(tickRate, workerList) {
    override fun handle() {
        for (worker in workers) {
            worker.onTick()
        }
    }
}