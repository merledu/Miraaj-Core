package riscv

import chisel3._

class datamem extends Module {
  val io = IO (new Bundle {
		val load = Input(UInt(1.W))
		val store = Input(UInt(1.W))
		val address = Input(UInt(8.W))
		val storeData = Input(SInt(32.W))
		val dataOut = Output(SInt(32.W))
  })
	val mem = Mem(1024,SInt(32.W))
	when(io.load === 1.U){
		io.dataOut := mem(io.address)
	}.otherwise{
		io.dataOut := DontCare
	}
	when(io.store === 1.U){
		mem(io.address) := io.storeData
	}.otherwise{
		io.dataOut := DontCare
	}

}
