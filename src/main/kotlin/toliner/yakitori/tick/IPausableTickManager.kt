/*
 * Copyright (c) 2018. toliner. All rights reserved.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package toliner.yakitori.tick

/**
 * 中断と再開が可能な[ITickManager]です。
 * 途中で中断する可能性がある場合、[run]ではなく[start]を使って開始してください。
 */
interface IPausableTickManager : ITickManager {
    /**
     * tick処理を、中断可能な形で開始します。
     * 中断されている場合は再開します。
     */
    fun start()

    /**
     * tick処理を中断します。
     */
    fun pause()
}