(function() {
    $('#tabelapedidos').on('click', '.js-delete', function() {
        let botaoClicado = $(this);
        $('#btnsim').attr('data-id', botaoClicado.attr('data-id'));
        $('#modalpedido').modal('show');
    });

    $(document).on('click', '#btnsim', function() {
        let botaoClicado = $(this);
        let id = botaoClicado.attr('data-id');

        // Adiciona estado de carregamento no botão
        botaoClicado.prop('disabled', true).text('Excluindo...');

        $.ajax({
            url: '/pedidos/delete/' + id,
            method: 'GET',
            success: function() {
                window.location.href = '/pedidos';
            },
            error: function() {
                alert('Erro ao excluir o pedido. Tente novamente.');
                botaoClicado.prop('disabled', false).text('Sim');
            }
        });
    });
})();
