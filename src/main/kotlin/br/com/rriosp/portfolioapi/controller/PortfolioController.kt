package br.com.rriosp.portfolioapi.controller

import br.com.rriosp.portfolioapi.model.Asset
import br.com.rriosp.portfolioapi.service.PortfolioService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal

@RestController
@RequestMapping("/api/portfolio")
class PortfolioController(private val portfolioService: PortfolioService) {

    /**
     * Adiciona um ativo no portfolio.
     * O endpoint invoca o metodo addAsset do PortfolioService,
     * que salva o ativo no banco de dados e retorna o ativo adicionado.
     *
     * @param asset O ativo a ser adicionado.
     * @return O ativo adicionado.
     */
    @PostMapping
    fun createAsset(@RequestBody asset: Asset): ResponseEntity<Asset> {
        val savedAsset = portfolioService.addAsset(asset)
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAsset)
    }

    /**
     * Retorna todos os ativos do portfolio.
     *
     * @return Lista de ativos.
     */
    @GetMapping
    fun listAssets(): ResponseEntity<List<Asset>> {
        val assets = portfolioService.getAllAssets()
        return ResponseEntity.ok(assets)
    }

    /**
     * Calcula o valor total investido no portfolio.
     *
     * @return Valor total investido.
     */
    @GetMapping("/total")
    fun getTotalInvested(): ResponseEntity<BigDecimal> {
        val totalInvested = portfolioService.calculateTotalInvested()
        return ResponseEntity.ok(totalInvested)
    }
}