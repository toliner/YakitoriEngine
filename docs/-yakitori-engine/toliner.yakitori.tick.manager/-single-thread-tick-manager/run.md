[YakitoriEngine](../../index.md) / [toliner.yakitori.tick.manager](../index.md) / [SingleThreadTickManager](index.md) / [run](./run.md)

# run

`fun run(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Overrides [ITickManager.run](../../toliner.yakitori.tick/-i-tick-manager/run.md)

愚直に直列処理を行います。
このメソッドを呼び出したスレッドで処理を開始するため、
途中で中断や終了をすることはできません。

