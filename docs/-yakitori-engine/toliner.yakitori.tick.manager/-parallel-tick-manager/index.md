[YakitoriEngine](../../index.md) / [toliner.yakitori.tick.manager](../index.md) / [ParallelTickManager](./index.md)

# ParallelTickManager

`class ParallelTickManager : `[`TimerTickManager`](../-timer-tick-manager/index.md)

コルーチンを用いてtick処理を非同期的に処理する[TimerTickManager](../-timer-tick-manager/index.md)の実装です。
全てのtick処理は非同期的に処理されます。
同時実行数は実行環境に依存します。
実行順序は不定です。
このクラスを利用する場合、全ての管理対象となる[ITickWorker](../../toliner.yakitori.tick/-i-tick-worker/index.md)は非同期的に実行されることを留意して作成する必要があります。

### Parameters

`tickRate` - 1秒あたりの最大tick数です。tpsの上限はこの値になります。

`workerList` - 管理対象の[ITickWorker](../../toliner.yakitori.tick/-i-tick-worker/index.md)の参照を保持する可変リストです。初期値は[LinkedList](http://docs.oracle.com/javase/8/docs/api/java/util/LinkedList.html)です。空のリストが推奨されます。

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ParallelTickManager(tickRate: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, workerList: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`ITickWorker`](../../toliner.yakitori.tick/-i-tick-worker/index.md)`> = LinkedList())`<br>コルーチンを用いてtick処理を非同期的に処理する[TimerTickManager](../-timer-tick-manager/index.md)の実装です。 全てのtick処理は非同期的に処理されます。 同時実行数は実行環境に依存します。 実行順序は不定です。 このクラスを利用する場合、全ての管理対象となる[ITickWorker](../../toliner.yakitori.tick/-i-tick-worker/index.md)は非同期的に実行されることを留意して作成する必要があります。 |

### Inherited Properties

| Name | Summary |
|---|---|
| [workers](../-timer-tick-manager/workers.md) | `open val workers: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`ITickWorker`](../../toliner.yakitori.tick/-i-tick-worker/index.md)`>`<br>Timerによって別のスレッドからアクセスされるため、コンストラクタで与えられた初期リストを用いた スレッドセーフなリストを生成します。 |

### Functions

| Name | Summary |
|---|---|
| [handle](handle.md) | `fun handle(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>[task](#)から委譲されたtick処理です。 |

### Inherited Functions

| Name | Summary |
|---|---|
| [pause](../-timer-tick-manager/pause.md) | `open fun pause(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>tick処理を中断します。 |
| [run](../-timer-tick-manager/run.md) | `open fun run(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>tick処理を開始します。 この処理によってスレッドがブロックされるか否か(処理がこのスレッドで行われるか別のスレッドで行われるか)は実装に依存します。 中断可能か否かは実装に依存します。 |
| [start](../-timer-tick-manager/start.md) | `open fun start(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>tick処理を、中断可能な形で開始します。 中断されている場合は再開します。 |
