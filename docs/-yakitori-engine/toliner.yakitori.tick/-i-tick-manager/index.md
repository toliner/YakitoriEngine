[YakitoriEngine](../../index.md) / [toliner.yakitori.tick](../index.md) / [ITickManager](./index.md)

# ITickManager

`interface ITickManager`

[ITickWorker](../-i-tick-worker/index.md)を管理し、tick処理を司るクラスのインターフェースです。
全ての標準実装は[toliner.yakitori.tick.manager](../../toliner.yakitori.tick.manager/index.md)パッケージに存在します。

**See Also**

[ITickWorker](../-i-tick-worker/index.md)

[IPausableTickManager](../-i-pausable-tick-manager/index.md)

[AbstractTickManager](../../toliner.yakitori.tick.manager/-abstract-tick-manager/index.md)

[SingleThreadTickManager](../../toliner.yakitori.tick.manager/-single-thread-tick-manager/index.md)

[TimerTickManager](../../toliner.yakitori.tick.manager/-timer-tick-manager/index.md)

[SingleThreadTimerTickManager](../../toliner.yakitori.tick.manager/-single-thread-timer-tick-manager/index.md)

[ParallelTickManager](../../toliner.yakitori.tick.manager/-parallel-tick-manager/index.md)

### Properties

| Name | Summary |
|---|---|
| [tps](tps.md) | `abstract val tps: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)<br>tpsとは、tick per second、つまり1秒あたりのtick数のことです。 実測のtpsを取得します。 精度・更新頻度は実装に依存します。 |

### Functions

| Name | Summary |
|---|---|
| [addWorker](add-worker.md) | `abstract fun addWorker(worker: `[`ITickWorker`](../-i-tick-worker/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>管理対象となる[ITickWorker](../-i-tick-worker/index.md)を追加します。 |
| [minusAssign](minus-assign.md) | `abstract operator fun minusAssign(worker: `[`ITickWorker`](../-i-tick-worker/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>管理対象から特定の[ITickWorker](../-i-tick-worker/index.md)を削除します。 標準実装において、これは[removeWorker](remove-worker.md)のラッパーです。 |
| [plusAssign](plus-assign.md) | `abstract operator fun plusAssign(worker: `[`ITickWorker`](../-i-tick-worker/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>管理対象となる[ITickWorker](../-i-tick-worker/index.md)を追加する、+=演算子のオーバーロードです。 標準実装において、これは[addWorker](add-worker.md)のラッパーです。 |
| [removeWorker](remove-worker.md) | `abstract fun removeWorker(worker: `[`ITickWorker`](../-i-tick-worker/index.md)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>管理対象から特定の[ITickWorker](../-i-tick-worker/index.md)を削除します。 |
| [run](run.md) | `abstract fun run(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>tick処理を開始します。 この処理によってスレッドがブロックされるか否か(処理がこのスレッドで行われるか別のスレッドで行われるか)は実装に依存します。 中断可能か否かは実装に依存します。 |
| [workerContains](worker-contains.md) | `abstract fun workerContains(worker: `[`ITickWorker`](../-i-tick-worker/index.md)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>特定の[ITickWorker](../-i-tick-worker/index.md)が管理対象に含まれているかを確認します。 |

### Inheritors

| Name | Summary |
|---|---|
| [AbstractTickManager](../../toliner.yakitori.tick.manager/-abstract-tick-manager/index.md) | `abstract class AbstractTickManager : `[`ITickManager`](./index.md)<br>全ての[ITickManager](./index.md)の標準実装の基底となる抽象クラスです。 |
| [IPausableTickManager](../-i-pausable-tick-manager/index.md) | `interface IPausableTickManager : `[`ITickManager`](./index.md)<br>中断と再開が可能な[ITickManager](./index.md)です。 途中で中断する可能性がある場合、[run](run.md)ではなく[start](../-i-pausable-tick-manager/start.md)を使って開始してください。 |
