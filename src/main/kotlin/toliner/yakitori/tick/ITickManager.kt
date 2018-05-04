package toliner.yakitori.tick


interface ITickManager {
    val tps: Float

    fun addWorker(worker: ITickWorker)
    fun removeWorker(worker: ITickWorker): Boolean
    fun workerContains(worker: ITickWorker): Boolean

    operator fun plusAssign(worker: ITickWorker)
    operator fun minusAssign(worker: ITickWorker)

    fun start()
    fun stop()
}