package toliner.yakitori.tick.manager

import toliner.yakitori.tick.ITickWorker

class SingleThreadTickManager(private val tickRate: Int, override val workers: MutableList<ITickWorker> = ArrayList()) : AbstractTickManager() {

    init {
        if (tickRate <= 0) {
            throw IllegalArgumentException("tickRate must be positive")
        }
    }

    private val tickTime = 1000 / tickRate
    private var oldTime = System.currentTimeMillis()
    private var tickCount = 0L
        set(value) {
            val count = value % tickRate
            if (count == 0L) {
                val now = System.currentTimeMillis()
                tps = count / (now - oldTime).toFloat()
                oldTime = now
            }
            field = count
        }

    override fun run() {
        while (true) {
            tickCount++
            for (worker in workers) {
                worker.onTick()
            }
            val delay = tickTime - System.currentTimeMillis() + oldTime
            if (delay > 0) {
                Thread.sleep(delay)
            }
        }
    }
}