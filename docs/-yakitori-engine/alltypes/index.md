

焼き鳥エンジンは、Minecraftライクな形でのゲーム開発を行うためのゲームエンジンです。
ゲームの処理は、**ロジック処理を行う"サーバー"と、レンダー処理を行う"クライアント"の2層に分割されます**。
サーバーとクライアントでは、処理単位が異なります。
サーバーでは"tick"と呼ばれる、専用の処理単位が用いられます。
全てのサーバーでの処理はtick単位で行われ、1秒あたりのtick数を指定することでゲームの速度を調整することができます。
クライアントでは、従来の"frame"という処理単位が用いられます。
クライアントは、ユーザー入力の処理及び描画処理のみを行うことによってfpsを向上させよりなめらかな描画を行うことができます。

### All Types

| Name | Summary |
|---|---|
| [toliner.yakitori.tick.manager.AbstractTickManager](../toliner.yakitori.tick.manager/-abstract-tick-manager/index.md) | 全ての[ITickManager](../toliner.yakitori.tick/-i-tick-manager/index.md)の標準実装の基底となる抽象クラスです。 |
| [toliner.yakitori.tick.IPausableTickManager](../toliner.yakitori.tick/-i-pausable-tick-manager/index.md) | 中断と再開が可能な[ITickManager](../toliner.yakitori.tick/-i-tick-manager/index.md)です。 途中で中断する可能性がある場合、[run](../toliner.yakitori.tick/-i-tick-manager/run.md)ではなく[start](../toliner.yakitori.tick/-i-pausable-tick-manager/start.md)を使って開始してください。 |
| [toliner.yakitori.tick.ITickManager](../toliner.yakitori.tick/-i-tick-manager/index.md) | [ITickWorker](../toliner.yakitori.tick/-i-tick-worker/index.md)を管理し、tick処理を司るクラスのインターフェースです。 全ての標準実装は[toliner.yakitori.tick.manager](../toliner.yakitori.tick.manager/index.md)パッケージに存在します。 |
| [toliner.yakitori.tick.ITickWorker](../toliner.yakitori.tick/-i-tick-worker/index.md) | tick処理を行うオブジェクトが実装すべきインターフェースです。 全てのインスタンスは[ITickManager](../toliner.yakitori.tick/-i-tick-manager/index.md)で管理されます。 |
| [toliner.yakitori.tick.manager.ParallelTickManager](../toliner.yakitori.tick.manager/-parallel-tick-manager/index.md) | コルーチンを用いてtick処理を非同期的に処理する[TimerTickManager](../toliner.yakitori.tick.manager/-timer-tick-manager/index.md)の実装です。 全てのtick処理は非同期的に処理されます。 同時実行数は実行環境に依存します。 実行順序は不定です。 このクラスを利用する場合、全ての管理対象となる[ITickWorker](../toliner.yakitori.tick/-i-tick-worker/index.md)は非同期的に実行されることを留意して作成する必要があります。 |
| [toliner.yakitori.tick.manager.SingleThreadTickManager](../toliner.yakitori.tick.manager/-single-thread-tick-manager/index.md) | 最も単純な[ITickManager](../toliner.yakitori.tick/-i-tick-manager/index.md)の実装です。 全ての処理は直列的に行われます。 tick処理間の間隔は、システム時間の差分を用いて管理されます。 runメソッドは実行されたスレッドで処理を開始します。 |
| [toliner.yakitori.tick.manager.SingleThreadTimerTickManager](../toliner.yakitori.tick.manager/-single-thread-timer-tick-manager/index.md) | 最も単純な[TimerTickManager](../toliner.yakitori.tick.manager/-timer-tick-manager/index.md)の実装です。 [SingleThreadTickManager](../toliner.yakitori.tick.manager/-single-thread-tick-manager/index.md)と同じ方法でtick処理を行います。 [SingleThreadTickManager](../toliner.yakitori.tick.manager/-single-thread-tick-manager/index.md)と比べて、 [Timer](http://docs.oracle.com/javase/8/docs/api/java/util/Timer.html)によって生成されたスレッドで実行されるため、呼び出しスレッドをブロックしないという利点があります。 |
| [toliner.yakitori.tick.manager.TimerTickManager](../toliner.yakitori.tick.manager/-timer-tick-manager/index.md) | [Timer](http://docs.oracle.com/javase/8/docs/api/java/util/Timer.html)を用いて、より厳密にtickの処理時間を管理する[ITickManager](../toliner.yakitori.tick/-i-tick-manager/index.md)の実装のための抽象クラスです。 全てのtick処理はTimerによって別スレッドで実行されます。 そのため、停止・再開が可能です。 [tps](../toliner.yakitori.tick.manager/-abstract-tick-manager/tps.md)は、tickRateで指定した回数、tick処理が行われるごとに更新されます。 |
