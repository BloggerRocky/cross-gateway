docker run -p 8904:8904 -p 7399:7399 \
    -e PARAMS="
    --sever.port=8904
    --cross-gateway.address=http://192.168.1.102:8901
    --cross-gateway.groupId=10001
    --cross-gateway.gatewayId=cross-gateway-g4
    --cross-gateway.gatewayName=电商配送网关
    --cross-gateway.gatewayAddress=192.168.1.102:7399" \
    --name cross-gateway-engine-03 -d cross-gateway-engine:1.0.0
