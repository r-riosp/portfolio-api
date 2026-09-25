package br.com.rriosp.portfolioapi.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal

/**
 * Classe que representa um ativo no portfolio.
 *
 * @property id Identificador único do ativo.
 * @property ticker Ticker do ativo.
 * @property quantity Quantidade de ativos.
 * @property averagePrice Preço médio de compra do ativo.
 */
@Entity
@Table(name = "tb_assets")
data class Asset @JvmOverloads constructor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val ticker: String,
    val quantity: Int,
    val averagePrice: BigDecimal
)