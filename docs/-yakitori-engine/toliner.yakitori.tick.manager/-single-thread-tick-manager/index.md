[YakitoriEngine](../../index.md) / [toliner.yakitori.tick.manager](../index.md) / [SingleThreadTickManager](./index.md)

# SingleThreadTickManager

`class SingleThreadTickManager : `[`AbstractTickManager`](../-abstract-tick-manager/index.md)

最も単純な[ITickManager](../../toliner.yakitori.tick/-i-tick-manager/index.md)の実装です。
全ての処理は直列的に行われます。
tick処理間の間隔は、システム時間の差分を用いて管理されます。
runメソッドは実行されたスレッドで処理を開始します。

### Parameters

`tickRate` - 1秒あたりの最大tick数です。tpsの上限はこの値になります。

`workers` - 管理対象の[ITickWorker](../../toliner.yakitori.tick/-i-tick-worker/index.md)の参照を保持する可変リストです。初期値は[ArrayList](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-array-list/index.html)です。空のリストが推奨されます。

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `SingleThreadTickManager(tickRate: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, workers: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`ITickWorker`](../../toliner.yakitori.tick/-i-tick-worker/index.md)`> = ArrayList())`<br>最も単純な[ITickManager](../../toliner.yakitori.tick/-i-tick-manager/index.md)の実装です。 全ての処理は直列的に行われます。 tick処理間の間隔は、システム時間の差分を用いて管理されます。 runメソッドは実行されたスレッドで処理を開始します。 |

### Properties

| Name | Summary |
|---|---|
| [workers](workers.md) | `val workers: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`ITickWorker`](../../toliner.yakitori.tick/-i-tick-worker/index.md)`>`<br>管理対象の[ITickWorker](../../toliner.yakitori.tick/-i-tick-worker/index.md)の参照を保持する可変リストです。初期値は[ArrayList](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-array-list/index.html)です。空のリストが推奨されます。 |

### Inherited Properties

| Name | Summary |
|---|---|
| [tps](../-abstract-tick-manager/tps.md) | `open var tps: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)<br>[ITickManager](../../toliner.yakitori.tick/-i-tick-manager/index.md)で定義された[ITickManager.tps](../../toliner.yakitori.tick/-i-tick-manager/tps.md)の実装です。 動的な更新を行うために、protectedなセッターが追加で実装されています。 |

### Functions

| Name | Summary |
|---|---|
| [run](run.md) | `fun run(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>愚直に直列処理を行います。 このメソッドを呼び出したスレッドで処理を開始するため、 途中で中断や終了をすることはできません。 |

### Inherited Functions

| Name | Summary |
|---|---|
| [addWorker](../-abstract-tick-manager/add-worker.md) | `open fun addWorker(worker: `[`ITickWorker`](../../toliner.yakitori.tick/-i-tick-worker/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>管理対象となる[ITickWorker](../../toliner.yakitori.tick/-i-tick-worker/index.md)を追加します。 |
| [minusAssign](../-abstract-tick-manager/minus-assign.md) | `open operator fun minusAssign(worker: `[`ITickWorker`](../../toliner.yakitori.tick/-i-tick-worker/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>管理対象から特定の[ITickWorker](../../toliner.yakitori.tick/-i-tick-worker/index.md)を削除します。 標準実装において、これは[removeWorker](../-abstract-tick-manager/remove-worker.md)のラッパーです。 |
| [plusAssign](../-abstract-tick-manager/plus-assign.md) | `open operator fun plusAssign(worker: `[`ITickWorker`](../../toliner.yakitori.tick/-i-tick-worker/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>管理対象となる[ITickWorker](../../toliner.yakitori.tick/-i-tick-worker/index.md)を追加する、+=演算子のオーバーロードです。 標準実装において、これは[addWorker](../-abstract-tick-manager/add-worker.md)のラッパーです。 |
| [removeWorker](../-abstract-tick-manager/remove-worker.md) | `open fun removeWorker(worker: `[`ITickWorker`](../../toliner.yakitori.tick/-i-tick-worker/index.md)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>管理対象から特定の[ITickWorker](../../toliner.yakitori.tick/-i-tick-worker/index.md)を削除します。 |
| [workerContains](../-abstract-tick-manager/worker-contains.md) | `open fun workerContains(worker: `[`ITickWorker`](../../toliner.yakitori.tick/-i-tick-worker/index.md)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>特定の[ITickWorker](../../toliner.yakitori.tick/-i-tick-worker/index.md)が管理対象に含まれているかを確認します。 |
