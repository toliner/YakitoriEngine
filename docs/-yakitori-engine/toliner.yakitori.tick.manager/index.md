[YakitoriEngine](../index.md) / [toliner.yakitori.tick.manager](./index.md)

## Package toliner.yakitori.tick.manager

このパッケージは、[toliner.yakitori.tick.ITickManager](../toliner.yakitori.tick/-i-tick-manager/index.md)の実装を提供します。

### Types

| Name | Summary |
|---|---|
| [AbstractTickManager](-abstract-tick-manager/index.md) | `abstract class AbstractTickManager : `[`ITickManager`](../toliner.yakitori.tick/-i-tick-manager/index.md)<br>全ての[ITickManager](../toliner.yakitori.tick/-i-tick-manager/index.md)の標準実装の基底となる抽象クラスです。 |
| [ParallelTickManager](-parallel-tick-manager/index.md) | `class ParallelTickManager : `[`TimerTickManager`](-timer-tick-manager/index.md)<br>コルーチンを用いてtick処理を非同期的に処理する[TimerTickManager](-timer-tick-manager/index.md)の実装です。 全てのtick処理は非同期的に処理されます。 同時実行数は実行環境に依存します。 実行順序は不定です。 このクラスを利用する場合、全ての管理対象となる[ITickWorker](../toliner.yakitori.tick/-i-tick-worker/index.md)は非同期的に実行されることを留意して作成する必要があります。 |
| [SingleThreadTickManager](-single-thread-tick-manager/index.md) | `class SingleThreadTickManager : `[`AbstractTickManager`](-abstract-tick-manager/index.md)<br>最も単純な[ITickManager](../toliner.yakitori.tick/-i-tick-manager/index.md)の実装です。 全ての処理は直列的に行われます。 tick処理間の間隔は、システム時間の差分を用いて管理されます。 runメソッドは実行されたスレッドで処理を開始します。 |
| [SingleThreadTimerTickManager](-single-thread-timer-tick-manager/index.md) | `class SingleThreadTimerTickManager : `[`TimerTickManager`](-timer-tick-manager/index.md)<br>最も単純な[TimerTickManager](-timer-tick-manager/index.md)の実装です。 [SingleThreadTickManager](-single-thread-tick-manager/index.md)と同じ方法でtick処理を行います。 [SingleThreadTickManager](-single-thread-tick-manager/index.md)と比べて、 [Timer](http://docs.oracle.com/javase/8/docs/api/java/util/Timer.html)によって生成されたスレッドで実行されるため、呼び出しスレッドをブロックしないという利点があります。 |
| [TimerTickManager](-timer-tick-manager/index.md) | `abstract class TimerTickManager : `[`AbstractTickManager`](-abstract-tick-manager/index.md)`, `[`IPausableTickManager`](../toliner.yakitori.tick/-i-pausable-tick-manager/index.md)<br>[Timer](http://docs.oracle.com/javase/8/docs/api/java/util/Timer.html)を用いて、より厳密にtickの処理時間を管理する[ITickManager](../toliner.yakitori.tick/-i-tick-manager/index.md)の実装のための抽象クラスです。 全てのtick処理はTimerによって別スレッドで実行されます。 そのため、停止・再開が可能です。 [tps](-abstract-tick-manager/tps.md)は、tickRateで指定した回数、tick処理が行われるごとに更新されます。 |
