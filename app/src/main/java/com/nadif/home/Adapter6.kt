import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.nadif.home.Modal4
import com.nadif.home.R
import java.util.*

class Adapter6(var Modallist4: ArrayList<Modal4>) : RecyclerView.Adapter<Adapter6.ViewHolder>(), Filterable {

    private var searchList = ArrayList<Modal4>(Modallist4)

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    private var onItemClickListener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener) {
        onItemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_menu, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(Modallist4[position])
    }

    override fun getItemCount(): Int {
        return Modallist4.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onItemClickListener?.onItemClick(position)
                }
            }
        }

        fun bindItems(modal4: Modal4) {
            val image = itemView.findViewById(R.id.title_image) as ShapeableImageView
            val heading = itemView.findViewById(R.id.tvHeading) as TextView
            val constraint = itemView.findViewById(R.id.constraint1) as ConstraintLayout

            image.setImageResource(modal4.ImageId4)
            heading.text = modal4.heading

            // Menambahkan logika klik item saat tidak dalam mode pencarian
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onItemClickListener?.onItemClick(position)
                }
            }
        }
    }


    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val filteredList = ArrayList<Modal4>()

                if (constraint.isNullOrEmpty()) {
                    filteredList.addAll(Modallist4)
                } else {
                    val query = constraint.toString().toLowerCase(Locale.ROOT).trim()
                    for (item in Modallist4) {
                        if (item.heading.toLowerCase(Locale.ROOT).contains(query)) {
                            filteredList.add(item)
                        }
                    }
                }

                val filterResults = FilterResults()
                filterResults.values = filteredList

                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                searchList.clear()
                searchList.addAll(results?.values as ArrayList<Modal4>)
                notifyDataSetChanged()
            }
        }
    }
}
