package magazinestore.entity;
// Generated 27-apr-2019 19.55.30 by Hibernate Tools 5.2.12.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "dettagli_ordine", catalog = "magazinestoredb")
@NamedQueries({
	@NamedQuery(name = "DettagliOrdine.countByRivista",
				query = "SELECT COUNT(*) FROM DettagliOrdine od WHERE od.rivista.rivistaId =:rivistaId")})

public class DettagliOrdine implements java.io.Serializable {

	private DettagliOrdineId id = new DettagliOrdineId();
	private RivistaOrder rivistaOrder;
	private Rivista rivista;
	
	public DettagliOrdine() {
	}

	public DettagliOrdine(DettagliOrdineId id) {
		this.id = id;
	}

	public DettagliOrdine(DettagliOrdineId id, RivistaOrder rivistaOrder, Rivista rivista) {
		this.id = id;
		this.rivistaOrder = rivistaOrder;
		this.rivista = rivista;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "ordineId", column = @Column(name = "ordine_id",nullable = false)),
			@AttributeOverride(name = "rivistaId", column = @Column(name = "rivista_id",nullable = false))})
	
	public DettagliOrdineId getId() {
		return this.id;
	}

	public void setId(DettagliOrdineId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "rivista_id", insertable = false, updatable = false,nullable = false)
	public Rivista getRivista() {
		return this.rivista;
	}

	public void setRivista(Rivista rivista) {
		this.rivista = rivista;
		this.id.setRivista(rivista);
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ordine_id", insertable = false, updatable = false,nullable = false)
	public RivistaOrder getRivistaOrder() {
		return this.rivistaOrder;
	}

	public void setRivistaOrder(RivistaOrder rivistaOrder) {
		this.rivistaOrder = rivistaOrder;
		this.id.setRivistaOrder(rivistaOrder);
	}
}