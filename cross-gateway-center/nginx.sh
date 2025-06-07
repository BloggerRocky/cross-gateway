docker run \
--name Nginx \
-d \
-v /Users/fuzhengwei/1024/KnowledgePlanet/cross-gateway/cross-gateway/doc/data/html:/usr/share/nginx/html \
-v /Users/fuzhengwei/1024/KnowledgePlanet/cross-gateway/cross-gateway/doc/data/nginx/nginx.conf:/etc/nginx/nginx.conf \
-p 8090:80 \
nginx
