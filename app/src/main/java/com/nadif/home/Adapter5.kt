import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.nadif.home.Modal5
import com.nadif.home.R

class Adapter5(private val Modallist5 : ArrayList<Modal5>) : RecyclerView.Adapter<Adapter5.Myviewholder>(){
//
//
//    private lateinit var mListener : onItemClickListener
//
//    interface onItemClickListener{
//
//        fun onItemClick(position : Int)
//
//    }
//
//    fun setOnItemClickListener(listener: onItemClickListener){
//
//        mListener = listener
//
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myviewholder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_menu,parent, false)
        return Myviewholder(itemView)
    }

    override fun onBindViewHolder(holder: Myviewholder, position: Int) {
        val currentItem = Modallist5[position]
        holder.titleImage3.setImageResource(currentItem.ImageId4)
    }

    override fun getItemCount(): Int {
        return Modallist5.size
    }

    class Myviewholder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val titleImage3 : ShapeableImageView = itemView.findViewById(R.id.title_image)
//
//        init {
//
//            itemView.setOnClickListener {
//
//                listener.onItemClick(adapterPosition)
//
//            }
//
//
//        }
    }

}
