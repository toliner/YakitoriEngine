/*
 * Copyright (c) 2018. toliner. All rights reserved.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package toliner.yakitori.tick

/**
 * tick処理を行うオブジェクトが実装すべきインターフェースです。
 * 全てのインスタンスは[ITickManager]で管理されます。
 */
interface ITickWorker {
    /**
     * [ITickManager]から呼ばれる、tick処理です。
     */
    fun onTick()
}