[YakitoriEngine](../../index.md) / [toliner.yakitori.tick](../index.md) / [IPausableTickManager](./index.md)

# IPausableTickManager

`interface IPausableTickManager : `[`ITickManager`](../-i-tick-manager/index.md)

中断と再開が可能な[ITickManager](../-i-tick-manager/index.md)です。
途中で中断する可能性がある場合、[run](../-i-tick-manager/run.md)ではなく[start](start.md)を使って開始してください。

### Inherited Properties

| Name | Summary |
|---|---|
| [tps](../-i-tick-manager/tps.md) | `abstract val tps: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)<br>tpsとは、tick per second、つまり1秒あたりのtick数のことです。 実測のtpsを取得します。 精度・更新頻度は実装に依存します。 |

### Functions

| Name | Summary |
|---|---|
| [pause](pause.md) | `abstract fun pause(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>tick処理を中断します。 |
| [start](start.md) | `abstract fun start(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>tick処理を、中断可能な形で開始します。 中断されている場合は再開します。 |

### Inherited Functions

| Name | Summary |
|---|---|
| [addWorker](../-i-tick-manager/add-worker.md) | `abstract fun addWorker(worker: `[`ITickWorker`](../-i-tick-worker/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>管理対象となる[ITickWorker](../-i-tick-worker/index.md)を追加します。 |
| [minusAssign](../-i-tick-manager/minus-assign.md) | `abstract operator fun minusAssign(worker: `[`ITickWorker`](../-i-tick-worker/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>管理対象から特定の[ITickWorker](../-i-tick-worker/index.md)を削除します。 標準実装において、これは[removeWorker](../-i-tick-manager/remove-worker.md)のラッパーです。 |
| [plusAssign](../-i-tick-manager/plus-assign.md) | `abstract operator fun plusAssign(worker: `[`ITickWorker`](../-i-tick-worker/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>管理対象となる[ITickWorker](../-i-tick-worker/index.md)を追加する、+=演算子のオーバーロードです。 標準実装において、これは[addWorker](../-i-tick-manager/add-worker.md)のラッパーです。 |
| [removeWorker](../-i-tick-manager/remove-worker.md) | `abstract fun removeWorker(worker: `[`ITickWorker`](../-i-tick-worker/index.md)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>管理対象から特定の[ITickWorker](../-i-tick-worker/index.md)を削除します。 |
| [run](../-i-tick-manager/run.md) | `abstract fun run(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>tick処理を開始します。 この処理によってスレッドがブロックされるか否か(処理がこのスレッドで行われるか別のスレッドで行われるか)は実装に依存します。 中断可能か否かは実装に依存します。 |
| [workerContains](../-i-tick-manager/worker-contains.md) | `abstract fun workerContains(worker: `[`ITickWorker`](../-i-tick-worker/index.md)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>特定の[ITickWorker](../-i-tick-worker/index.md)が管理対象に含まれているかを確認します。 |

### Inheritors

| Name | Summary |
|---|---|
| [TimerTickManager](../../toliner.yakitori.tick.manager/-timer-tick-manager/index.md) | `abstract class TimerTickManager : `[`AbstractTickManager`](../../toliner.yakitori.tick.manager/-abstract-tick-manager/index.md)`, `[`IPausableTickManager`](./index.md)<br>[Timer](http://docs.oracle.com/javase/8/docs/api/java/util/Timer.html)を用いて、より厳密にtickの処理時間を管理する[ITickManager](../-i-tick-manager/index.md)の実装のための抽象クラスです。 全てのtick処理はTimerによって別スレッドで実行されます。 そのため、停止・再開が可能です。 [tps](../../toliner.yakitori.tick.manager/-abstract-tick-manager/tps.md)は、tickRateで指定した回数、tick処理が行われるごとに更新されます。 |
