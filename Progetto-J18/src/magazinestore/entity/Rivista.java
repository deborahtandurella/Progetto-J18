package magazinestore.entity;
// Generated 27-apr-2019 19.55.30 by Hibernate Tools 5.2.12.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Base64;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Rivista generated by hbm2java
 */
@Entity
@Table(name = "rivista", catalog = "magazinestoredb", uniqueConstraints = @UniqueConstraint(columnNames = "title"))
@NamedQueries({
	@NamedQuery(name = "Rivista.findAll", query = "SELECT r FROM Rivista r"),
	@NamedQuery(name = "Rivista.findByTitle", query = "SELECT r FROM Rivista r WHERE r.title =:title"),
	@NamedQuery(name = "Rivista.countAll", query = "SELECT COUNT(*) FROM Rivista r"),
	@NamedQuery(name = "Rivista.countByCategory", query = "SELECT COUNT(r) FROM Rivista r "
						+ "WHERE r.categoria.categoriaId =:catId"),
	@NamedQuery(name="Rivista.findByCategory",query="SELECT b FROM Rivista b JOIN "
	                  + "Categoria c ON b.categoria.categoriaId = c.categoriaId AND c.categoriaId = :catId"),
	@NamedQuery(name="Rivista.listNew", query= "SELECT b FROM Rivista b ORDER BY b.publishDate DESC"),
	@NamedQuery(name="Rivista.search", query="SELECT b FROM Rivista b WHERE b.title LIKE '%' || :keyword || '%'"
			+ "OR b.description LIKE '%' || :keyword || '%'")

})

public class Rivista implements java.io.Serializable {

	private Integer rivistaId;
	private Categoria categoria;
	private String title;
	private String description;
	private byte[] immagine;
	private String base64Image;
	private float price;
	private Date publishDate;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rivistaId == null) ? 0 : rivistaId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rivista other = (Rivista) obj;
		if (rivistaId == null) {
			if (other.rivistaId != null)
				return false;
		} else if (!rivistaId.equals(other.rivistaId))
			return false;
		return true;
	}
	private Date lastUpdtaedTime;
	private Set<Recensione> recensiones = new HashSet<Recensione>(0);
	private Set<DettagliOrdine> dettagliOrdines = new HashSet<DettagliOrdine>(0);

	public Rivista() {
	}

	public Rivista(Categoria categoria, String title, String description, byte[] immagine, float price,
			Date publishDate, Date lastUpdtaedTime) {
		this.categoria = categoria;
		this.title = title;
		this.description = description;
		this.immagine = immagine;
		this.price = price;
		this.publishDate = publishDate;
		this.lastUpdtaedTime = lastUpdtaedTime;
	}

	public Rivista(Categoria categoria, String title,String description, byte[] immagine, float price,
			Date publishDate, Date lastUpdtaedTime, Set<Recensione> recensiones, Set<DettagliOrdine> dettagliOrdines) {
		this.categoria = categoria;
		this.title = title;
		this.description = description;
		this.immagine = immagine;
		this.price = price;
		this.publishDate = publishDate;
		this.lastUpdtaedTime = lastUpdtaedTime;
		this.recensiones = recensiones;
		this.dettagliOrdines = dettagliOrdines;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "rivista_id", unique = true, nullable = false)
	public Integer getRivistaId() {
		return this.rivistaId;
	}

	public void setRivistaId(Integer rivistaId) {
		this.rivistaId = rivistaId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "categoria_id", nullable = false)
	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Column(name = "title", unique = true, nullable = false, length = 128)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "description", nullable = false, length = 16777215)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "immagine", nullable = false)
	public byte[] getImmagine() {
		return this.immagine;
	}

	public void setImmagine(byte[] immagine) {
		this.immagine = immagine;
	}

	@Column(name = "price", nullable = false, length = 45)
	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "publish_date", nullable = false, length = 10)
	public Date getPublishDate() {
		return this.publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_updtaed_time", nullable = false, length = 19)
	public Date getLastUpdtaedTime() {
		return this.lastUpdtaedTime;
	}

	public void setLastUpdtaedTime(Date lastUpdtaedTime) {
		this.lastUpdtaedTime = lastUpdtaedTime;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rivista")
	public Set<Recensione> getRecensiones() {
		return this.recensiones;
	}

	public void setRecensiones(Set<Recensione> recensiones) {
		this.recensiones = recensiones;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rivista")
	public Set<DettagliOrdine> getDettagliOrdines() {
		return this.dettagliOrdines;
	}

	public void setDettagliOrdines(Set<DettagliOrdine> dettagliOrdines) {
		this.dettagliOrdines = dettagliOrdines;
	}
	
	@javax.persistence.Transient
	public String getBase64Image() {
		this.base64Image = Base64.getEncoder().encodeToString(this.immagine);
		return base64Image;
	}
	@javax.persistence.Transient
	public void setBase64Image(String base64) {
		
		this.base64Image=base64;
	}
}
