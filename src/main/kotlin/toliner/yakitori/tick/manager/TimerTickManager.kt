/*
 * Copyright (c) 2018. toliner. All rights reserved.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package toliner.yakitori.tick.manager

import toliner.yakitori.tick.IPausableTickManager
import toliner.yakitori.tick.ITickWorker
import java.util.*

abstract class TimerTickManager(tickRate: Long, workerList: MutableList<ITickWorker> = LinkedList()) : AbstractTickManager(), IPausableTickManager {

    init {
        if (tickRate <= 0) {
            throw IllegalArgumentException("tickRate must be positive")
        }
    }

    override val workers: MutableList<ITickWorker> = Collections.synchronizedList(workerList)!!
    protected val timer = Timer()
    protected val tickTime = 1000 / tickRate
    protected abstract val task: TimerTask

    override fun run() {
        timer.schedule(task, 0)
    }

    override fun start() {
        run()
    }

    override fun pause() {
        timer.cancel()
    }
}