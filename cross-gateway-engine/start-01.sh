docker run -p 8902:8902 -p 7397:7397 \
    -e PARAMS="
    --sever.port=8902
    --cross-gateway.address=http://192.168.1.102:8901
    --cross-gateway.groupId=10001
    --cross-gateway.gatewayId=cross-gateway-g4
    --cross-gateway.gatewayName=电商配送网关
    --cross-gateway.gatewayAddress=192.168.1.102:7397" \
    --name cross-gateway-engine-01 -d cross-gateway-engine:1.0.0
