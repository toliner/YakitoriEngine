[YakitoriEngine](../../index.md) / [toliner.yakitori.tick.manager](../index.md) / [AbstractTickManager](index.md) / [minusAssign](./minus-assign.md)

# minusAssign

`open operator fun minusAssign(worker: `[`ITickWorker`](../../toliner.yakitori.tick/-i-tick-worker/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Overrides [ITickManager.minusAssign](../../toliner.yakitori.tick/-i-tick-manager/minus-assign.md)

管理対象から特定の[ITickWorker](../../toliner.yakitori.tick/-i-tick-worker/index.md)を削除します。
標準実装において、これは[removeWorker](remove-worker.md)のラッパーです。

### Parameters

`worker` - 管理対象から削除する[ITickWorker](../../toliner.yakitori.tick/-i-tick-worker/index.md)