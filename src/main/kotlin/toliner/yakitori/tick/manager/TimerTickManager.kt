package toliner.yakitori.tick.manager

import toliner.yakitori.tick.IPauseableTickManager
import toliner.yakitori.tick.ITickWorker
import java.util.*

class TimerTickManager(private val tickRate: Long, workerList: MutableList<ITickWorker> = LinkedList()) : AbstractTickManager(), IPauseableTickManager {
    override val workers: MutableList<ITickWorker> = Collections.synchronizedList(workerList)!!
    private val timer = Timer()
    private val tickTime = 1000 / tickRate

    override fun run() {
        timer.schedule(object : TimerTask() {
            private var oldTime = 0L
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
                tickCount++
                for (worker in workers) {
                    worker.onTick()
                }
                timer.schedule(this, tickTime - System.currentTimeMillis() + oldTime)
            }
        }, 0)
    }

    override fun start() {
        run()
    }

    override fun stop() {
        timer.cancel()
    }
}