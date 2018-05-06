[YakitoriEngine](../../index.md) / [toliner.yakitori.tick](../index.md) / [ITickManager](index.md) / [minusAssign](./minus-assign.md)

# minusAssign

`abstract operator fun minusAssign(worker: `[`ITickWorker`](../-i-tick-worker/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

管理対象から特定の[ITickWorker](../-i-tick-worker/index.md)を削除します。
標準実装において、これは[removeWorker](remove-worker.md)のラッパーです。

### Parameters

`worker` - 管理対象から削除する[ITickWorker](../-i-tick-worker/index.md)