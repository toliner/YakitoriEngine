package toliner.yakitori.tick

interface IPauseableTickManager: ITickManager {
    fun start()
    fun stop()
}