    <?php
    use \Psr\Http\Message\ServerRequestInterface as Request;
    use \Psr\Http\Message\ResponseInterface as Response;

    require '../vendor/autoload.php';

    $config['displayErrorDetails'] = true;
    $config['addContentLengthHeader'] = false;
    
    $config['db']['host'] = "localhost";
    $config['db']['user'] = "root";
    $config['db']['pass'] = "root";
    $config['db']['dbname'] = "entregas";

    $app = new \Slim\App(["config" => $config]);
    $app->add(new Tuupola\Middleware\HttpBasicAuthentication([
        "users" => [
        "admin" => "admin"
        ]
    ]));
    $container = $app->getContainer();

    $container['db'] = function ($c) {
        $dbConfig = $c['config']['db'];
        $pdo = new PDO("mysql:host=" . $dbConfig['host'] . ";dbname=" .
            $dbConfig['dbname'], $dbConfig['user'], $dbConfig['pass']);
        $pdo->setAttribute(PDO::ATTR_ERRMODE,
            PDO::ERRMODE_EXCEPTION);
        $pdo->setAttribute(PDO::ATTR_DEFAULT_FETCH_MODE,
            PDO::FETCH_ASSOC);
        $db = new NotORM($pdo);
        return $db;
    }; 

    $app->put('/entrega/{id}', function (Request $request, Response $response) {
        //Atualiza o produto identificado pelo id
        $dadosEntrega = $request->getParsedBody();
        $id = $request->getAttribute('id');
        $result = null;
        $entrega = $this->db->entregas()->where('id', $id)->fetch();

        $data = array(
                    "id"=> $id,
                    "numero_pedido" =>$dadosEntrega['numero_pedido'],
                    "id_cliente" =>$dadosEntrega['id_cliente'],
                    "nome_recebedor" =>$dadosEntregajson['nome_recebedor'],
                    "cpf_recebedor" =>$dadosEntrega['cpf_recebedor'],
                    "data_entrega" =>$dadosEntrega['data_entrega']
                );
        if ($entrega->fetch()) {
            $result = $entrega->update($data);
        }
        return $response->withJson($result);
    });

    $app->delete('/entrega/delete/{id}', function (Request $request, Response $response) {
        $id = $request->getAttribute('id');
        $entrega = $this->db->entregas()->where('id', $id);
        if ($entrega->fetch()) {
            $deleted = $entrega->delete();
        }
        return $response->getBody->write("Entrega deletada");
    });

        $app->run();
