docker run -p 8901:8901 \
-v /Users/fuzhengwei/1024/KnowledgePlanet/cross-gateway/cross-gateway/doc/data/nginx:/data/nginx \
-v /var/run/docker.sock:/var/run/docker.sock \
--name cross-gateway-center \
-d cross-gateway-center:1.0.0 CP4-LISTEN:8001,fork,reuseaddr UNIX-CONNECT:/var/run/docker.sock TCP4-LISTEN:8001,fork,reuseaddr UNIX-CONNECT:/var/run/docker.sock
