#!/bin/bash

read message_name
git add . && git commit -m $message_name && git push
