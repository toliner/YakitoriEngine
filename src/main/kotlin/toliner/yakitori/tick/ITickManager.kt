/*
 * Copyright (c) 2018. toliner. All rights reserved.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package toliner.yakitori.tick


interface ITickManager {
    val tps: Float

    fun addWorker(worker: ITickWorker)
    fun removeWorker(worker: ITickWorker): Boolean
    fun workerContains(worker: ITickWorker): Boolean

    operator fun plusAssign(worker: ITickWorker)
    operator fun minusAssign(worker: ITickWorker)

    fun run()
}