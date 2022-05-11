# Stage 1


FROM node

RUN mkdir -p /app
WORKDIR /app

COPY . .

RUN npm install
RUN npm install --save mapbox-gl
RUN npm install --save @types/mapbox-gl


RUN npm run build --prod

CMD ["npm","start"]


