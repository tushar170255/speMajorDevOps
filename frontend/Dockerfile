# Stage 1





FROM node:16-alpine as build-step



RUN mkdir -p /app



WORKDIR /app



COPY package.json /app



RUN npm install
RUN npm install --save mapbox-gl
RUN npm install --save @types/mapbox-gl



COPY . /app



RUN npm run build --prod



 



# Stage 2


FROM nginx:1.17.1-alpine



COPY --from=build-step /app/dist angular-app


