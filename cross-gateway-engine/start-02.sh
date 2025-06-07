docker run -p 8903:8903 -p 7398:7398 \
    -e PARAMS="
    --sever.port=8903
    --cross-gateway.address=http://192.168.1.102:8901
    --cross-gateway.groupId=10001
    --cross-gateway.gatewayId=cross-gateway-g4
    --cross-gateway.gatewayName=电商配送网关
    --cross-gateway.gatewayAddress=192.168.1.102:7398" \
    --name cross-gateway-engine-02 -d cross-gateway-engine:1.0.0
