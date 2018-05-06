[YakitoriEngine](../../index.md) / [toliner.yakitori.tick](../index.md) / [ITickManager](index.md) / [plusAssign](./plus-assign.md)

# plusAssign

`abstract operator fun plusAssign(worker: `[`ITickWorker`](../-i-tick-worker/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

管理対象となる[ITickWorker](../-i-tick-worker/index.md)を追加する、+=演算子のオーバーロードです。
標準実装において、これは[addWorker](add-worker.md)のラッパーです。

### Parameters

`worker` - 管理対象に追加する[ITickWorker](../-i-tick-worker/index.md)