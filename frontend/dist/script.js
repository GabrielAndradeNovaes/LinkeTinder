var candidatos = [];
var empresas = [];
document.addEventListener('DOMContentLoaded', function () {
    var _a, _b, _c, _d;
    var conteudo = document.getElementById('conteudo');
    if (!conteudo) {
        console.error("Elemento 'conteudo' não encontrado.");
        return;
    }
    (_a = document.getElementById('cadastro-candidato')) === null || _a === void 0 ? void 0 : _a.addEventListener('click', function () {
        conteudo.innerHTML = "\n            <h2>Cadastro de Candidato</h2>\n            <form id=\"form-candidato\" class=\"cadastro-form\">\n                <label for=\"nome\">Nome:</label>\n                <input type=\"text\" id=\"nome\" required>\n                <label for=\"email\">Email:</label>\n                <input type=\"email\" id=\"email\" required>\n                <label for=\"cpf\">CPF:</label>\n                <input type=\"text\" id=\"cpf\" required>\n                <label for=\"idade\">Idade:</label>\n                <input type=\"number\" id=\"idade\" required>\n                <label for=\"estado\">Estado:</label>\n                <input type=\"text\" id=\"estado\" required>\n                <label for=\"cep\">CEP:</label>\n                <input type=\"text\" id=\"cep\" required>\n                <label for=\"competencias\">Compet\u00EAncias (separadas por v\u00EDrgula):</label>\n                <textarea id=\"competencias\" required></textarea>\n                <button type=\"submit\">Cadastrar</button>\n            </form>\n        ";
        var formCandidato = document.getElementById('form-candidato');
        if (formCandidato) {
            formCandidato.addEventListener('submit', function (event) {
                event.preventDefault();
                var nome = document.getElementById('nome').value;
                var email = document.getElementById('email').value;
                var cpf = document.getElementById('cpf').value;
                var idade = parseInt(document.getElementById('idade').value);
                var estado = document.getElementById('estado').value;
                var cep = document.getElementById('cep').value;
                var competencias = document.getElementById('competencias').value.split(',').map(function (s) { return s.trim(); });
                candidatos.push({ nome: nome, email: email, cpf: cpf, idade: idade, estado: estado, cep: cep, competencias: competencias });
                alert('Candidato cadastrado com sucesso!');
                conteudo.innerHTML = '';
            });
        }
        else {
            console.error("Formulário de candidato não encontrado.");
        }
    });
    (_b = document.getElementById('cadastro-empresa')) === null || _b === void 0 ? void 0 : _b.addEventListener('click', function () {
        conteudo.innerHTML = "\n            <h2>Cadastro de Empresa</h2>\n            <form id=\"form-empresa\" class=\"cadastro-form\">\n                <label for=\"nome\">Nome:</label>\n                <input type=\"text\" id=\"nome\" required>\n                <label for=\"emailCorporativo\">Email Corporativo:</label>\n                <input type=\"email\" id=\"emailCorporativo\" required>\n                <label for=\"cnpj\">CNPJ:</label>\n                <input type=\"text\" id=\"cnpj\" required>\n                <label for=\"pais\">Pa\u00EDs:</label>\n                <input type=\"text\" id=\"pais\" required>\n                <label for=\"estado\">Estado:</label>\n                <input type=\"text\" id=\"estado\" required>\n                <label for=\"cep\">CEP:</label>\n                <input type=\"text\" id=\"cep\" required>\n                <label for=\"competencias\">Compet\u00EAncias (separadas por v\u00EDrgula):</label>\n                <textarea id=\"competencias\" required></textarea>\n                <button type=\"submit\">Cadastrar</button>\n            </form>\n        ";
        var formEmpresa = document.getElementById('form-empresa');
        if (formEmpresa) {
            formEmpresa.addEventListener('submit', function (event) {
                event.preventDefault();
                var nome = document.getElementById('nome').value;
                var emailCorporativo = document.getElementById('emailCorporativo').value;
                var cnpj = document.getElementById('cnpj').value;
                var pais = document.getElementById('pais').value;
                var estado = document.getElementById('estado').value;
                var cep = document.getElementById('cep').value;
                var competencias = document.getElementById('competencias').value.split(',').map(function (s) { return s.trim(); });
                empresas.push({ nome: nome, emailCorporativo: emailCorporativo, cnpj: cnpj, pais: pais, estado: estado, cep: cep, competencias: competencias });
                alert('Empresa cadastrada com sucesso!');
                conteudo.innerHTML = '';
            });
        }
        else {
            console.error("Formulário de empresa não encontrado.");
        }
    });
    (_c = document.getElementById('perfil-candidato')) === null || _c === void 0 ? void 0 : _c.addEventListener('click', function () {
        if (conteudo) {
            conteudo.innerHTML = "\n                <h2>Perfil de Candidatos</h2>\n                <p>Informa\u00E7\u00F5es completas ser\u00E3o exibidas ap\u00F3s um match.</p>\n                ".concat(candidatos.map(function (candidato) { return "\n                    <div class=\"perfil\">\n                        <p>Idade: ".concat(candidato.idade, "</p>\n                        <p>Estado: ").concat(candidato.estado, "</p>\n                        <p>Compet\u00EAncias: ").concat(candidato.competencias.join(', '), "</p>\n                    </div>\n                "); }).join(''), "\n\n                <h2>Gr\u00E1fico de Candidatos por Skill</h2>\n                <div class=\"grafico-barras\">\n                    ").concat(gerarGraficoSkills(), "\n                </div>\n            ");
        }
    });
    (_d = document.getElementById('perfil-empresa')) === null || _d === void 0 ? void 0 : _d.addEventListener('click', function () {
        if (conteudo) {
            conteudo.innerHTML = "\n                <h2>Perfil de Empresas</h2>\n                <p>Informa\u00E7\u00F5es completas ser\u00E3o exibidas ap\u00F3s um match.</p>\n                ".concat(empresas.map(function (empresa) { return "\n                    <div class=\"perfil\">\n                        <p>Estado: ".concat(empresa.estado, "</p>\n                        <p>Compet\u00EAncias: ").concat(empresa.competencias.join(', '), "</p>\n                    </div>\n                "); }).join(''), "\n    \n                <h2>Gr\u00E1fico de Candidatos por Skill</h2>\n                <div class=\"grafico-barras\" id=\"grafico-competencias\">\n                    ").concat(gerarGraficoSkills(), "\n                </div>\n            ");
        }
    });
    function gerarGraficoSkills() {
        var skillsContagem = {};
        candidatos.forEach(function (candidato) {
            candidato.competencias.forEach(function (skill) {
                skillsContagem[skill] = (skillsContagem[skill] || 0) + 1;
            });
        });
        var maxContagem = Math.max.apply(Math, Object.values(skillsContagem));
        var alturaMaxima = 200;
        return Object.entries(skillsContagem).map(function (_a) {
            var skill = _a[0], contagem = _a[1];
            var alturaBarra = (contagem / maxContagem) * alturaMaxima;
            return "\n                <div style=\"display: inline-block; margin: 0 10px; text-align: center; vertical-align: bottom;\">\n                    <div style=\"width: 20px; height: ".concat(alturaBarra, "px; background-color: #007bff; display: inline-block; vertical-align: bottom;\"></div>\n                    <div>").concat(skill, " (").concat(contagem, ")</div>\n                </div>\n            ");
        }).join('');
    }
});
