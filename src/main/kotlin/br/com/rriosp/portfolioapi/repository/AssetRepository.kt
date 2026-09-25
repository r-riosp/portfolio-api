package br.com.rriosp.portfolioapi.repository

import br.com.rriosp.portfolioapi.model.Asset
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AssetRepository : JpaRepository<Asset, Long>