package ditech.feature

import com.houjp.ditech16
import ditech.datastructure.OrderAbs
import ditech.feature.ftrait.FDTTrait

object FDTShiftDemand extends FDTTrait{

  def main(args:Array[String]): Unit ={
    run(ditech16.data_pt,this.getClass.getSimpleName.replace("$",""))
  }

  override def collect_order(ord:OrderAbs,fs:collection.mutable.Map[(Int,Int), Double]) ={
    if (-1 != ord.start_district_id) {
      fs((ord.start_district_id, ord.time_id)) =
        fs.getOrElse((ord.start_district_id, ord.time_id), 0.0) + 1.0
    }
  }

  override def getTimeID(tid:Int) = if( tid == 1)  144 else tid - 1
}
