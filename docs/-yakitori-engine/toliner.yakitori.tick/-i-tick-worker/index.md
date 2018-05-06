[YakitoriEngine](../../index.md) / [toliner.yakitori.tick](../index.md) / [ITickWorker](./index.md)

# ITickWorker

`interface ITickWorker`

tick処理を行うオブジェクトが実装すべきインターフェースです。
全てのインスタンスは[ITickManager](../-i-tick-manager/index.md)で管理されます。

### Functions

| Name | Summary |
|---|---|
| [onTick](on-tick.md) | `abstract fun onTick(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>[ITickManager](../-i-tick-manager/index.md)から呼ばれる、tick処理です。 |
