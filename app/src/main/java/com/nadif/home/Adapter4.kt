import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nadif.home.Modal4
import com.nadif.home.R

class Adapter4(private val dataList: ArrayList<Modal4>) :
    RecyclerView.Adapter<Adapter4.ViewHolder>() {

    private var listener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_menu, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val modal4 = dataList[position]
        holder.bind(modal4)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.title_image)
        private val textView: TextView = itemView.findViewById(R.id.tvHeading)

        fun bind(modal4: Modal4) {
            textView.text = modal4.heading
            Glide.with(itemView.context)
                .load(modal4.ImageId4)
                .into(imageView)

            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener?.onItemClick(position)
                }
            }
        }
    }

    // Filter
    private var filterList: ArrayList<Modal4> = ArrayList()

    init {
        filterList.addAll(dataList)
    }

    fun filter(filterText: String) {
        dataList.clear()
        if (filterText.isEmpty()) {
            dataList.addAll(filterList)
        } else {
            val query = filterText.toLowerCase().trim()
            for (item in filterList) {
                if (item.heading.toLowerCase().contains(query)) {
                    dataList.add(item)
                }
            }
        }
        notifyDataSetChanged()
    }
}
