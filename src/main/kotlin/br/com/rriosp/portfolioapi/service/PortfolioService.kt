package br.com.rriosp.portfolioapi.service

import br.com.rriosp.portfolioapi.model.Asset
import br.com.rriosp.portfolioapi.repository.AssetRepository
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class PortfolioService(
    private val assetRepository: AssetRepository
) {

    /**
     * Adiciona um ativo no portfolio. O ativo é salvo no banco de dados e o objeto é exibido no console.
     * O ideal é que a saída no console seja por meio de um logger, e não pelo metodo print.
     *
     * @param asset O ativo a ser adicionado.
     * @return O ativo adicionado.
     */
    fun addAsset(asset: Asset): Asset {
        return assetRepository.save(asset)
            .also { print("Asset added: $it") }
    }

    /**
     * Retorna todos os ativos do portfolio.
     *
     * @return Lista de ativos.
     */
    fun getAllAssets(): List<Asset> {
        return assetRepository.findAll()
    }

    /**
     * Calcula o valor total investido no portfolio.
     * O cálculo é feito pelo valor total de cada ativo (averagePrice * quantity) e somado a um total.
     *
     * @return Valor total investido.
     */
    fun calculateTotalInvested(): BigDecimal {
        val assets = assetRepository.findAll()

        return assets.fold(BigDecimal.ZERO) { total, asset ->
            val assetTotalValue = asset.averagePrice.multiply(BigDecimal(asset.quantity))
            total.add(assetTotalValue)
        }
    }
}