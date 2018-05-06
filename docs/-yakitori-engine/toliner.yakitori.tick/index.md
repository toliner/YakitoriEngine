[YakitoriEngine](../index.md) / [toliner.yakitori.tick](./index.md)

## Package toliner.yakitori.tick

このパッケージ及びサブパッケージ群は、サーバー処理のうち、tick処理に強く関連するものを扱います。
このパッケージにおいてはインターフェースのみが提供され、その実装は全てサブパッケージに委譲されます。


### Types

| Name | Summary |
|---|---|
| [IPausableTickManager](-i-pausable-tick-manager/index.md) | `interface IPausableTickManager : `[`ITickManager`](-i-tick-manager/index.md)<br>中断と再開が可能な[ITickManager](-i-tick-manager/index.md)です。 途中で中断する可能性がある場合、[run](-i-tick-manager/run.md)ではなく[start](-i-pausable-tick-manager/start.md)を使って開始してください。 |
| [ITickManager](-i-tick-manager/index.md) | `interface ITickManager`<br>[ITickWorker](-i-tick-worker/index.md)を管理し、tick処理を司るクラスのインターフェースです。 全ての標準実装は[toliner.yakitori.tick.manager](../toliner.yakitori.tick.manager/index.md)パッケージに存在します。 |
| [ITickWorker](-i-tick-worker/index.md) | `interface ITickWorker`<br>tick処理を行うオブジェクトが実装すべきインターフェースです。 全てのインスタンスは[ITickManager](-i-tick-manager/index.md)で管理されます。 |
