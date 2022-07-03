package com.murilonerdx.vendasbackend.controller;

import java.time.LocalDate;

import com.murilonerdx.vendasbackend.controller.request.DashboardData;
import com.murilonerdx.vendasbackend.model.repository.ClienteRepository;
import com.murilonerdx.vendasbackend.model.repository.ProdutoRepository;
import com.murilonerdx.vendasbackend.model.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin("*")
public class DashboardController {

    @Autowired
    private VendaRepository vendas;
    @Autowired
    private ClienteRepository clientes;
    @Autowired
    private ProdutoRepository produtos;

    @GetMapping
    public DashboardData getDashBoard() {
        long vendasCount = vendas.count();
        long clientesCount = clientes.count();
        long produtosCount = produtos.count();

        var anoCorrente = LocalDate.now().getYear();
        var vendasPorMes = vendas.obterSomatoriaVendasPorMes(anoCorrente);

        return new DashboardData(produtosCount, clientesCount, vendasCount, vendasPorMes);

    }
}
