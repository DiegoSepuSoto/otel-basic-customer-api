build:
	@docker build . -t diegosepusoto/otel-basic-customer-api:local

start:
	@docker run --platform linux/amd64 \
	-d \
	-p 8080:8080 \
	--name otel-basic-customer-api \
	-e OTEL_TRACES_EXPORTER=none \
	-e OTEL_METRICS_EXPORTER=none \
	-e OTEL_LOGS_EXPORTER=logging \
	-e OTEL_RESOURCE_ATTRIBUTES=service.name=customer-api,service.version=1.0,deployment.environment=local \
	diegosepusoto/otel-basic-customer-api:local

stop:
	@docker rm -f otel-basic-customer-api

.PHONY: build start