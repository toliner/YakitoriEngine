[YakitoriEngine](../../index.md) / [toliner.yakitori.tick.manager](../index.md) / [AbstractTickManager](index.md) / [plusAssign](./plus-assign.md)

# plusAssign

`open operator fun plusAssign(worker: `[`ITickWorker`](../../toliner.yakitori.tick/-i-tick-worker/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Overrides [ITickManager.plusAssign](../../toliner.yakitori.tick/-i-tick-manager/plus-assign.md)

管理対象となる[ITickWorker](../../toliner.yakitori.tick/-i-tick-worker/index.md)を追加する、+=演算子のオーバーロードです。
標準実装において、これは[addWorker](add-worker.md)のラッパーです。

### Parameters

`worker` - 管理対象に追加する[ITickWorker](../../toliner.yakitori.tick/-i-tick-worker/index.md)