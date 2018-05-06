[YakitoriEngine](../../index.md) / [toliner.yakitori.tick](../index.md) / [ITickManager](index.md) / [run](./run.md)

# run

`abstract fun run(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

tick処理を開始します。
この処理によってスレッドがブロックされるか否か(処理がこのスレッドで行われるか別のスレッドで行われるか)は実装に依存します。
中断可能か否かは実装に依存します。

