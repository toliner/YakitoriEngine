/*
 * Copyright (c) 2018. toliner. All rights reserved.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package toliner.yakitori.tick.manager

import toliner.yakitori.tick.ITickManager
import toliner.yakitori.tick.ITickWorker

/**
 * 全ての[ITickManager]の標準実装の基底となる抽象クラスです。
 */
abstract class AbstractTickManager : ITickManager {

    /**
     * 管理対象の[ITickWorker]の参照を保持する可変リストです。
     */
    protected abstract val workers: MutableList<ITickWorker>
    /**
     * [ITickManager]で定義された[ITickManager.tps]の実装です。
     * 動的な更新を行うために、protectedなセッターが追加で実装されています。
     */
    override var tps = 0f
        protected set

    override fun addWorker(worker: ITickWorker) {
        workers.add(worker)
    }

    override fun removeWorker(worker: ITickWorker): Boolean {
        return workers.remove(worker)
    }

    override fun workerContains(worker: ITickWorker): Boolean {
        return workers.contains(worker)
    }

    override operator fun plusAssign(worker: ITickWorker) {
        addWorker(worker)
    }

    override operator fun minusAssign(worker: ITickWorker) {
        removeWorker(worker)
    }

}